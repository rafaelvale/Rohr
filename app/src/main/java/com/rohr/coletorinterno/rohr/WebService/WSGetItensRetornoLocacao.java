package com.rohr.coletorinterno.rohr.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by rafael.marques on 21/09/2016.
 */
public class WSGetItensRetornoLocacao {
    public boolean WSGetItensRetornoLocacao() {

        Boolean t = true;

        int WorkOrderId = 0;
        int IdItem;

        try {
            String NameSpace = "http://10.11.5.27:8022/WebServicesColetor";
            String url = "http://10.11.5.27:8022/WebServicesColetor/ColetorMobileWebService1.asmx";
            String Metodo = "";
            String soap = "";

            SoapObject soapObject = new SoapObject(NameSpace, Metodo);
            soapObject.addProperty("WorkOrderId", WorkOrderId);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;

            envelope.setOutputSoapObject(soapObject);
            HttpTransportSE transportSE = new HttpTransportSE(url);

            transportSE.call(soap, envelope);

            String resultado = envelope.getResponse().toString();
            JSONArray jsonArray = new JSONArray(resultado);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = new JSONObject(String.valueOf(i));

                IdItem = jsonObject.getInt("IdItem");
                WorkOrderId = jsonObject.getInt("WorkOrderId");

            }

        } catch (IOException e) {
            e.printStackTrace();
            t = false;
        } catch (XmlPullParserException e) {
            e.printStackTrace();
            t = false;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return t;
    }
}
