package com.example.springclient.properties;

public class Liquor {

    private String productName;
    private String productType;
    private String productMade;
    private String productCategory;
    private float productPrice;
    private String productYear;
    private boolean productSanitaryRegister;
    private String credentialsClient;
    private int ageClient;

    public Liquor(String productName, String productType, String productMade,
                  String productCategory, float productPrice, String productYear,
                  boolean productSanitaryRegister, String credentialsClient, int ageClient) {
        this.productName = productName;
        this.productType = productType;
        this.productMade = productMade;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productYear = productYear;
        this.productSanitaryRegister = productSanitaryRegister;
        this.credentialsClient = credentialsClient;
        this.ageClient = ageClient;
    }

    public Liquor(){}




    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductMade() {
        return productMade;
    }

    public void setProductMade(String productMade) {
        this.productMade = productMade;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductYear() {
        return productYear;
    }

    public void setProductYear(String productYear) {
        this.productYear = productYear;
    }

    public boolean getProductSanitaryRegister() {
        return productSanitaryRegister;
    }

    public void setProductSanitaryRegister(boolean productSanitaryRegister) {
        this.productSanitaryRegister = productSanitaryRegister;
    }

    public String getCredentialsClient() {
        return credentialsClient;
    }

    public void setCredentialsClient(String credentialsClient) {
        this.credentialsClient = credentialsClient;
    }

    public int getAgeClient() {
        return ageClient;
    }

    public void setAgeClient(int ageClient) {
        this.ageClient = ageClient;
    }
}
