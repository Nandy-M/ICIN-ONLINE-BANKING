package com.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.model.UserHistory;

public interface UserHistoryRepository  extends JpaRepository<UserHistory, Integer> {

}
