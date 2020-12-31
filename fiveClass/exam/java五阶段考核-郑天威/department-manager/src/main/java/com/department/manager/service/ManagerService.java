package com.department.manager.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author 夜神
 */
public interface ManagerService extends UserDetailsService {
}
