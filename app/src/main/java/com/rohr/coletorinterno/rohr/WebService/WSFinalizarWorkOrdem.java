package com.rohr.coletorinterno.rohr.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by rafael.marques on 21/09/2016.
 */
public class WSFinalizarWorkOrdem {


    int workOrderId;


    public Boolean WSFinalizarWorkOdem(){

        Boolean T = true;

        try {

            String nameSpace = "http://10.11.5.27:8022/WebServicesColetor";
            String url = "http://10.11.5.27:8022/WebServicesColetor/ColetorMobileWebService1.asmx";
            String metodo = "FinalizarWorkOrdem";
            String soap = "http://10.11.5.27:8022/WebServicesColetor/FinalizarWorkOrdem";

            SoapObject soapObject = new SoapObject(nameSpace, metodo);
            soapObject.addProperty("WorkOrderId", workOrderId);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;

            envelope.setOutputSoapObject(soapObject);

            HttpTransportSE transportSE = new HttpTransportSE(url);

            transportSE.call(soap, envelope);

            String resultado = null;

            resultado = envelope.getResponse().toString();

            JSONArray jsonArray = null;

            jsonArray = new JSONArray(resultado);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }catch (XmlPullParserException e){
            e.printStackTrace();
            T = false;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return T;
    }

}