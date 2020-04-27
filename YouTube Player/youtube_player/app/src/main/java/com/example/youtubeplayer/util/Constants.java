package com.example.youtubeplayer.util;

public class Constants {
    //You need to generate your own api key from:
       //https://developers.google.com/youtube/registering_an_application
           //goto Credentials Page and generate your own Api key
               //->Don't forget to restrict your api key by registering your package name and SHA-1 key

    //How can you generate SHA-1 key:
       //1. Click on the gradle tab at the right side of the android studio window.
       //2. Click on Tasks->android and Double click on signingReport

    //The below api key won't work in your application because of the restrictions.
    public static final String API_KEY="AIzaSyACDsaqv33gB9w2cX0ZuIX927S6etO996c";
}
