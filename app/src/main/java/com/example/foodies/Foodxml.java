package com.example.foodies;


import android.content.Context;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

    public class Foodxml {    //XML JAVA FILE

        private Customlist [] data;
        private Context context;

        public Foodxml(Context c){
            this.context = c;

            //get an inputstream to xml
            InputStream stream = this.context.getResources().openRawResource(R.raw.resto);

            //parse xml to a document
            DocumentBuilder builder = null;
            Document xml = null;
            try{
                Log.e("*****","Inside XML parser");
                builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                xml = builder.parse(stream);

            }catch (Exception e) {}



            //slice document into 5 NodeList for name, address, etc
            NodeList nameList    = xml.getElementsByTagName("name");
            NodeList locationList = xml.getElementsByTagName("location");
            NodeList ratinglist   = xml.getElementsByTagName("rating");
            NodeList introlist= xml.getElementsByTagName("intro");
            NodeList addresslist=xml.getElementsByTagName("address");
            NodeList telelist=xml.getElementsByTagName("telephone");
            NodeList emaillist=xml.getElementsByTagName("email");
            NodeList desclist=xml.getElementsByTagName("description");
            NodeList urllist=xml.getElementsByTagName("url");
            NodeList idlist=xml.getElementsByTagName("id");
            NodeList image1list=xml.getElementsByTagName("image1");
            NodeList image2list=xml.getElementsByTagName("image2");
            NodeList image3list=xml.getElementsByTagName("image3");

            //NodeList imageList   = xml.getElementsByTagName("image");

            //traverse the list to make data
            data = new Customlist[nameList.getLength()];

            for (int i = 0; i < data.length; i++) {
                String name    = nameList.item(i).getFirstChild().getNodeValue();
                String location = locationList.item(i).getFirstChild().getNodeValue();
                String rating   = ratinglist.item(i).getFirstChild().getNodeValue();
                String intro= introlist.item(i).getFirstChild().getNodeValue();
                String address= addresslist.item(i).getFirstChild().getNodeValue();
                String tele= telelist.item(i).getFirstChild().getNodeValue();
                String email= emaillist.item(i).getFirstChild().getNodeValue();
                String desc=desclist.item(i).getFirstChild().getNodeValue();
                String url=urllist.item(i).getFirstChild().getNodeValue();
                String id=idlist.item(i).getFirstChild().getNodeValue();
                String image1=image1list.item(i).getFirstChild().getNodeValue();
                String image2=image2list.item(i).getFirstChild().getNodeValue();
                String image3=image3list.item(i).getFirstChild().getNodeValue();

                //String image   = imageList.item(i).getFirstChild().getNodeValue();

                data[i] = new Customlist(name,location,rating,intro,address,tele,email,desc,url,id,image1,image2,image3);
            }
        }

        public Customlist getfood(int i){
            return data[i];
        }
        public int    getLength(){
            return data.length;
        }
    }


