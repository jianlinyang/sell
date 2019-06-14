package com.shu.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**<h1>商品(包含类目)</h1>
 * @author yang
 * @date 2019/6/14 12:39
 */
@Data
public class ProductVO {
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("food")
    private List<ProductInfoVO> productInfoVOList;
}
