package com.marcos.LiterAlura.Service;

public interface IDataConverter {
    <T> T getData(String json, Class<T> tClass);
}
