package io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.groups;

import jakarta.validation.GroupSequence;

@GroupSequence({ ValidaNotBlank.class, ValidaDemais.class })
public interface OrdemValidacao {
}
