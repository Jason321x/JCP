package main.java.codePractice.oms.service.validator;

import main.java.codePractice.oms.dto.SalesOrderHeaderDTO;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: ValidateContext
 * @description: 校验器上下文
 * @author: jxx
 * @date: 2021/1/14 4:32 PM
 **/
public class ValidateContext {

    private SalesOrderHeaderDTO header;
    private Map<String, Object> extraContext = new HashMap<>();

    public ValidateContext(SalesOrderHeaderDTO header) {
        this.header = header;
//        this.zeroPriceVO = new ProductPriceVO();
//        zeroPriceVO.setSuggestPrice("0");
//        zeroPriceVO.setDealerSuggestPrice("0");
//        zeroPriceVO.setDealerMinPrice("0");
//        zeroPriceVO.setFactory("");
    }

//
//    public static ICrmService findCrmService() {
//        if (null != crmService) {
//            return crmService;
//        }
//        crmService = SpringContextUtil.getBean(ICrmService.class);
//        return crmService;
//    }
}
