package com.hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.repository.MemoryMemberRepository;

public class MemberService {
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	/**
	 * 회원 가입
	 */
	public Long join(Member member) {
		// 같은 이름이 있는 중복 회원 X
		vaildateDuplicateMember(member); // 중복 회원 검증
		
		memberRepository.save(member);
		return member.getId();
	}

	private void vaildateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
			.ifPresent(m -> {
				throw new IllegalStateException("이미 존재하는 회원입니다.");
			});
	}
	
	/**
	 * 전체 회원 조회
	 */
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}
	
	/**
	 * 회원 ID 조회
	 */
	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}
}
