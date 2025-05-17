package com.vietduc.hello_spring_boot.dto.request;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class VoucherRequest {
    private String code;// Mã voucher (vd: "SPRING2025") - dùng để khách hàng nhập khi thanh toán
    private Integer discountPercent;// So tien ma voucher giam 50k, 100k
    private Long minOrderValue;//Giá trị đơn hàng tối thiểu để vouceher có hiệu lực
    private LocalDateTime expiredAt;// Thời điểm voucher hết hạn (không còn dùng được nữa)
    private String description;// Mô tả voucher (vd: "Giảm 50% cho đơn hàng từ 500k trở lên")
}
