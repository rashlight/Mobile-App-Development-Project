package vn.edu.usth.ufood.api;

import com.google.gson.annotations.SerializedName;

public class Order {
    @SerializedName("productCost")
    private String productCost;
    @SerializedName("products")
    private String products;

    public Order(String productCost, String products) {
        this.productCost = productCost;
        this.products = products;
    }

    public String getProductCost() {
        return productCost;
    }

    public void setProductCost(String productCost) {
        this.productCost = productCost;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }
}
