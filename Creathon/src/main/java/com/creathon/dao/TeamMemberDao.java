package com.creathon.dao;

import java.util.List;

import com.creathon.bean.TeamMember;

public interface TeamMemberDao {

	public Boolean saveAndUpdate(TeamMember teamMember);
	public Integer deleteTeamMember(Integer teamMemberId);
	public TeamMember findTeamMemberById(Integer teamMemberId);
	public List<TeamMember> listOfTeamMemberByProdId(Integer productionHouseId);
	public List<TeamMember> listOfDirector(Integer productionHouseId);
	public List<TeamMember> listOfCinematographer(Integer productionHouseId);
	public List<TeamMember> listOfLocalLineProducer(Integer productionHouseId);
	public List<TeamMember> listOfArtDirector(Integer productionHouseId);
	public List<TeamMember> listOfCameraman(Integer productionHouseId);
}
