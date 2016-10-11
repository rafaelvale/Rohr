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
public class WSGetConferentes {

    public Boolean WSGetConferentes() {


        int id;
        String firstname;
        String lastname;
        String title;
        String notes;
        int cargo;

        Boolean t = true;

        try {
            String nameSpace = "http://10.11.5.27:8022/WebServicesColetor";
            String url = "http://10.11.5.27:8022/WebServicesColetor/ColetorMobileWebService1.asmx";
            String metodo = "GetConferentes";
            String soap = "http://10.11.5.27:8022/WebServicesColetor/GetConferentes";

            SoapObject soapObject = new SoapObject(nameSpace, metodo);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

            envelope.dotNet = true;

            envelope.setOutputSoapObject(soapObject);

            HttpTransportSE transportSE = new HttpTransportSE(url);
            transportSE.call(soap, envelope);

            String resultado = envelope.getResponse().toString();

            JSONArray jsonArray = new JSONArray(resultado);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                id = jsonObject.getInt("Id");
                firstname = jsonObject.getString("FirstName");
                lastname = jsonObject.getString("LastName");
                title = jsonObject.getString("Title");
                notes = jsonObject.getString("Notes");
                cargo = jsonObject.getInt("Cargo");
            }
        }catch (IOException e) {
            e.printStackTrace();
            t = false;

        }catch (XmlPullParserException e ){
            e.printStackTrace();
            t = false;
        }catch (JSONException e ){
            e.printStackTrace();
        }

        return t;


    }
}
