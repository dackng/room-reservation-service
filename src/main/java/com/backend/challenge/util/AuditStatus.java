package com.backend.challenge.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum AuditStatus {
   ACTIVE(true), INACTIVE(false);
   private Boolean value;
   
}