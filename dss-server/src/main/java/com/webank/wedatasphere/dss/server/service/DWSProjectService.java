/*
 * Copyright 2019 WeBank
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.webank.wedatasphere.dss.server.service;



import com.webank.wedatasphere.dss.appjoint.exception.AppJointErrorException;
import com.webank.wedatasphere.dss.common.entity.project.DWSProject;
import com.webank.wedatasphere.dss.common.entity.project.DWSProjectPublishHistory;
import com.webank.wedatasphere.dss.common.entity.project.DWSProjectVersion;
import com.webank.wedatasphere.dss.common.exception.DSSErrorException;
import com.webank.wedatasphere.dss.common.protocol.RequestDWSProject;

import java.util.Date;
import java.util.List;


public interface DWSProjectService {

    DWSProject getProjectByID(Long id);

    Long addProject(String userName, String name, String description, Long taxonomyID,String product,Integer applicationArea,String business) throws DSSErrorException, AppJointErrorException;

    void updateProject(long projectID, String name, String description, String userName , String product ,Integer applicationArea ,String business) throws AppJointErrorException;

    void deleteProject(long projectID, String userName, Boolean ifDelScheduler) throws DSSErrorException;

    DWSProject getLatestVersionProject(Long projectID);

    DWSProject getProjectByProjectVersionID(Long projectVersionID);

    Boolean isPublished(Long projectID);

    List<DWSProjectVersion> listAllProjectVersions(Long projectID);

    Long copyProject(Long projectVersionID, Long projectID, String projectName, String userName) throws DSSErrorException, InterruptedException, AppJointErrorException;

    void copyProjectVersionMax(Long projectVersionID, DWSProjectVersion maxVersion, DWSProjectVersion copyVersion, String userName, Long WTSSprojectID) throws DSSErrorException, InterruptedException;

    void publish(Long projectVersionID, String userName, String comment) throws DSSErrorException, InterruptedException, AppJointErrorException;

    Long createPublishHistory(String comment, Long creatorID, Long projectVersionID) throws DSSErrorException;

    void updatePublishHistory(Long projectVersionID, Integer status, Date updateTime);

    DWSProjectPublishHistory getPublishHistoryByID(Long projectVersionID);

    DWSProject getExecutionDWSProject(RequestDWSProject requestDWSProject) throws DSSErrorException;

    Long getAppjointProjectID(Long projectID, String nodeType);

    Long getAppjointProjectIDByApplicationName(Long projectID, String applicationName);
}

