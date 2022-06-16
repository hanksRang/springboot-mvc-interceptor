package com.hanksrang.springboot.mvcinterceptor.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;

@Data
public class QueryParams {

    private String id;

    @Length(min = 0, max = 1)
    private String name;

    private String gender;

    @Range(min = 0, max = 200)
    private Integer age;

    @SafeHtml
    private String content;

    private String creditCardNumber;

}
