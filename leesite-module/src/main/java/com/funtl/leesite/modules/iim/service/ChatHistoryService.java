/*
 * Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.funtl.leesite.modules.iim.service;

import java.util.List;

import com.funtl.leesite.common.persistence.Page;
import com.funtl.leesite.common.service.CrudService;
import com.funtl.leesite.modules.iim.dao.ChatHistoryDao;
import com.funtl.leesite.modules.iim.entity.ChatHistory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 聊天记录Service
 *
 * @author Lusifer
 * @version 2015-12-29
 */
@Service
@Transactional(readOnly = true)
public class ChatHistoryService extends CrudService<ChatHistoryDao, ChatHistory> {

	public ChatHistory get(String id) {
		return super.get(id);
	}

	public List<ChatHistory> findList(ChatHistory chatHistory) {
		return super.findList(chatHistory);
	}


	public Page<ChatHistory> findPage(Page<ChatHistory> page, ChatHistory entity) {
		entity.setPage(page);
		page.setList(dao.findLogList(entity));
		return page;
	}


	@Transactional(readOnly = false)
	public void save(ChatHistory chatHistory) {
		super.save(chatHistory);
	}

	@Transactional(readOnly = false)
	public void delete(ChatHistory chatHistory) {
		super.delete(chatHistory);
	}

	public int findUnReadCount(ChatHistory chatHistory) {
		return dao.findUnReadCount(chatHistory);
	}

}