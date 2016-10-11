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
public class WSGetWorkOrdensConferente {

    public Boolean WSGetWorkOrdensConferente(int idConferente) {
        Boolean t = true;
        int workOrderId = 0;
        String description;
        int nroOrdem;
        String placaVeiculo;
        String Obra;
        String Cliente;
        int WorkOrderTypeId;

        try {
            String nameSpace = "http://10.11.5.27:8022/WebServicesColetor";
            String url = "http://10.11.5.27:8022/WebServicesColetor/ColetorMobileWebService1.asmx";
            String metodo = "GetWorkOrdensConferente";
            String soap = "http://10.11.5.27:8022/WebServicesColetor/GetWorkOrdensConferente";

            SoapObject soapObject = new SoapObject(nameSpace, metodo);

            soapObject.addProperty("IdConferente", idConferente);


            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

            envelope.dotNet = true;

            envelope.setOutputSoapObject(soapObject);

            HttpTransportSE transportSE = new HttpTransportSE(url);
            transportSE.call(soap, envelope);


            String resultado = envelope.getResponse().toString();

            JSONArray jsonArray = new JSONArray(resultado);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                workOrderId = jsonObject.getInt("WorkOrderId");
                description = jsonObject.getString("Description");
                nroOrdem = jsonObject.getInt("NroOrdem");
                placaVeiculo = jsonObject.getString("PlacaVeiculo");
                Obra = jsonObject.getString("Obra");
                Cliente = jsonObject.getString("Cliente");
                WorkOrderTypeId = jsonObject.getInt("WorkOrderTypeId");

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
