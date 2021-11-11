package hu.microservice.medicare.security;

import java.util.function.Supplier;

@FunctionalInterface
public interface AuthorizationSupplier extends Supplier<String> {

}
