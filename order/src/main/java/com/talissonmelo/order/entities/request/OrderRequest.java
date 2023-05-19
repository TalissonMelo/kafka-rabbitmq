package com.talissonmelo.order.entities.request;

import jakarta.validation.constraints.NotBlank;

public record OrderRequest(@NotBlank(message = "Title is required") String title,
		@NotBlank(message = "Description is required") String description) {

}
