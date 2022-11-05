package com.Qacat.todo.Utilites;

import java.util.Properties;

public  class configUtils {

    private Properties properties;
    public static configUtils configUtils;
    public configUtils()
    {
        String env = System.getProperty("env","production");
        switch (env)
        {
            case"PRODUCTION":
                properties = propertiesUtils.loadProperties("src/test/java/com/Qacat/todo/Config/Production.properties");
                break;

            case"LOCAL":
                properties = propertiesUtils.loadProperties("src/test/java/com/Qacat/todo/Config/local.properties");
                break;

            default:
                throw new RuntimeException("NO environment found");
        }

      //properties = propertiesUtils.loadProperties("src/test/java/com/Qacat/todo/Config/Production.properties");

    }

    public static configUtils getInstance()
    {
        if(configUtils == null)
            configUtils = new configUtils();

        return configUtils;
    }


    public String GetBaseUrl()
    {
        String BaseUrl=  properties.getProperty("baseUrl");
        if(BaseUrl !=null)
            return BaseUrl;
        throw new RuntimeException("can not find Url into property file");

    }


    public String GetEmail()
    {
        String BaseUrl=  properties.getProperty("email");
        if(BaseUrl !=null)
            return BaseUrl;
        throw new RuntimeException("ca not find Email into property file");

    }


    public String GetPassword()
    {
        String BaseUrl=  properties.getProperty("password");
        if(BaseUrl !=null)
            return BaseUrl;
        throw new RuntimeException("ca not find password into property file");

    }






}
