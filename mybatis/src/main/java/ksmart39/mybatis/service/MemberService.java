package ksmart39.mybatis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart39.mybatis.dao.MemberMapper;
import ksmart39.mybatis.domain.Member;



@Service
@Transactional
public class MemberService {
	
	
	private static final Logger log = LoggerFactory.getLogger(MemberService.class);

	/*
	 * @Autowired private MemberMapper memberMapper;
	 */
	/*
	 * //setter 주입방식
	 * 
	 * private MemberMapper memberMapper;
	 * 
	 * @Autowired public void setMemberMapper(MemberMapper memberMapper) {
	 * this.memberMapper=memberMapper; }
	 */
	
	
	// 생성자 메서드 주입방식
	
	private final MemberMapper memberMapper;
	
	// 생략 가능
	@Autowired
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper =memberMapper;
	}
	
	
	
	@PostConstruct
	public void memberServiceInit() {
		log.info("=========================");
		log.info("MemberService 객체생성");
		log.info("=========================");
		/*
		 * System.out.println("==========================");
		 * System.out.println("MemberService 객체생성");
		 * System.out.println("==========================");
		 */
	}

	
	public boolean removeMember(String memberId, String memberPw) {
		//삭제여부
		boolean removeCheck = false;
		
		//비밀번호가 맞으면 삭제가 될수있게 
		Member member = memberMapper.getMemberInfoById(memberId);
		if(member !=null && memberPw.equals(member.getMemberPw())) {
			//삭제 프로세스
			//판매자일 경우 
			//1.주문테이블 ,상품,회원,로그인 테이블 삭제 
			if("2".equals(member.getMemberLevel())) {
				memberMapper.removeOderBySellerId(memberId);
				memberMapper.removeGoodsById(memberId);
			}
			//구매자 일경우
			//2. 주문 ,회원,로그인 테이블 삭제 
			if("3".equals(member.getMemberLevel())) {
				memberMapper.removeLoginById(memberId);
				memberMapper.removeOderById(memberId);
				
			}
			memberMapper.removeLoginById(memberId);
			memberMapper.removeMemberById(memberId);
			
			removeCheck= true;
		
		}
	
		return removeCheck;
	}
	
	

	
	public List<Member> getMemberList(Map<String, Object> paramMap){
		List<Member> memberList = memberMapper.getMemberList(paramMap);
	
		return memberList;
	}
	
	public int addMember(Member member) {
		int result = memberMapper.addMember(member);
		return result;
	}
	public Member getMemberInfoById(String memberId) {
		return memberMapper.getMemberInfoById(memberId);
	}
	public int modifyMember(Member member) {
		return memberMapper.modifyMember(member);
	}
	
	public Map<String,Object> loginMember(String memberId ,String memberPw) {
		//로그인 여부
		boolean loginCheck =false;
		//로그인결과 
		Map<String,Object> memberInfoMap = new HashMap<String,Object>();
		
		//로그인 처리
	Member member=	memberMapper.getMemberInfoById(memberId);
	
	if(member != null && memberPw.equals(member.getMemberPw())) {
		loginCheck =true;
		memberInfoMap.put("loginMember", member);
	}
		memberInfoMap.put("loginCheck", loginCheck);
		
		return memberInfoMap;
		
	}
		
		
	

}
