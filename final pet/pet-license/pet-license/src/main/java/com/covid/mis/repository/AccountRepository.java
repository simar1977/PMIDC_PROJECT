package com.covid.mis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covid.mis.bean.AccountBean;


public interface AccountRepository extends JpaRepository<AccountBean, Long> {

}
