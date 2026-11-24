package com.example.deviceassetsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Device {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String category;
    private String status;
    private LocalDateTime createTime;
}