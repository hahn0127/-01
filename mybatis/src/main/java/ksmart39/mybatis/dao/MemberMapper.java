package ksmart39.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.mybatis.domain.Member;

@Mapper
public interface MemberMapper {
	//회원 목록 조회
	public List<Member> getMemberList(Map<String,Object> paramMap);
	// 회원 정보 삭제
	public int removeMember(String memberId, String memberPw );
	//회원테이블 삭제 
	public int removeMemberById(String memberId );
	
	//상품테이블
	public int removeGoodsById(String memberId);
	
	//주문 테이블
	public int removeOderById(String memberId);
	public int removeOderBySellerId(String memberId);
	
	// 로그인테이블
	public int removeLoginById(String memberId);
	
	

	
	
	
	//회원정보수정
	public int modifyMember(Member member);
	
	//회원 가입
	public int addMember(Member member);
	// 회원 한명 조회
	public Member getMemberInfoById(String memberId);
	
	
}
