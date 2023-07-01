package com.inventory.management.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory implements Serializable {

    @NonNull
    @NotEmpty
    @JsonProperty("itemName")
    private String itemName;

    @JsonProperty("quantity")
    private Long quantity;
}
