
package com.mycompany.luyenthi3.Model;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.Set;
public class PhoneModel {
    private String id;
    private String name;
    private double price;
    private String image;
    private HashMap<String, String> errors;
    
    public PhoneModel() {
        super();
        this.errors = new HashMap<>();
    }
    
    @NotEmpty
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @NotEmpty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Min(value=1)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @NotEmpty
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public boolean validation() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<PhoneModel>> constraintViolations = validator.validate(this);
        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<PhoneModel> cv : constraintViolations) {
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
