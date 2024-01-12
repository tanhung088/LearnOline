package com.mycompany.luyenthi3.Model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.Set;

public class ProductModel {

    private int id;
    private String product_name;
    private double price;
    private String image;
    private HashMap<String, String>errors;
    
    public ProductModel(){
        super();
        this.errors = new HashMap<>();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotEmpty(message = "Product Name must be not empty!")
    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    @Min(value = 1)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @NotEmpty(message = "Image must be not empty!")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean validation() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<ProductModel>> constraintViolations = validator.validate(this);
        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<ProductModel> cv : constraintViolations) {
                errors.put(cv.getPropertyPath().toString(), cv.getMessage());
            }
            return true;
        }

        return false;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }
}
