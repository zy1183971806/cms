package com.example.shiordomo.bus.vo;

import com.example.shiordomo.bus.domain.Outport;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OutportVo extends Outport {

    /*
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer page = 1;
    private Integer limit = 10;

}
