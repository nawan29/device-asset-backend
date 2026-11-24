package com.example.deviceassetsystem.controller;

import com.example.deviceassetsystem.entity.Device;
import com.example.deviceassetsystem.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/devices")
@CrossOrigin // 允许跨域，前端才能访问
public class DeviceController {

    @Autowired
    private DeviceMapper deviceMapper;

    @GetMapping
    public List<Device> list() {
        return deviceMapper.selectList(null);
    }
    // 新增设备
    @PostMapping
    public boolean add(@RequestBody Device device) {
        return deviceMapper.insert(device) > 0;
    }

    // 修改设备
    @PutMapping
    public boolean update(@RequestBody Device device) {
        return deviceMapper.updateById(device) > 0;
    }

    // 删除设备
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return deviceMapper.deleteById(id) > 0;
    }
}