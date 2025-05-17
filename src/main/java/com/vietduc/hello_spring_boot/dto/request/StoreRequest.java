package com.vietduc.hello_spring_boot.dto.request;
import lombok.*;

@Getter
@Setter
public class StoreRequest {
    private String name;
    private String location;
    private String description;
}
