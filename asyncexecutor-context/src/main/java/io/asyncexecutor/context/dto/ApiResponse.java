package io.asyncexecutor.context.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T extends java.io.Serializable> implements java.io.Serializable {
  private String code;
  private String errMsg;
  private T response;

  public static <E extends Serializable> ApiResponse<E> ok() {
    return new ApiResponse<>("0", "", (E) new HashMap<String, Object>());
  }

  public static <E extends Serializable> ApiResponse<E> error(String errorMsg) {
    return new ApiResponse<>(errorMsg, "", (E) new HashMap<String, Object>());
  }

  public boolean hasError() {
    return false;
  }
}
