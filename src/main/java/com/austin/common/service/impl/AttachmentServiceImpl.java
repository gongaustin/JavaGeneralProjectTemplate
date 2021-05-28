package com.austin.common.service.impl;

import com.austin.common.entity.Attachment;
import com.austin.common.mapper.AttachmentMapper;
import com.austin.common.service.IAttachmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 附件表 服务实现类
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@Service
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper, Attachment> implements IAttachmentService {

}
