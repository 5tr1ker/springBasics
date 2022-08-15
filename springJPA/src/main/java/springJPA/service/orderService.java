package springJPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springJPA.base.ItemData;
import springJPA.base.Member;
import springJPA.base.OrderData;
import springJPA.repository.memberRepository;
import springJPA.repository.orderRepository;

@Service
public class orderService {

	@Autowired
	orderRepository ors;
	@Autowired
	memberRepository mrs;
	
	// 주문
	public long order(String userid , String itemname , int count) {
		
		// 엔티티 조회
		Member mv = mrs.findOne(userid);
		OrderData od = new OrderData();
		
		ItemData itemid = ItemData.createitem(itemname, count); // 생성 메소드 활용
//		itemid.setCount(count);
//		itemid.setName(itemname);

		od.addItem(mv, itemid);
		ors.save(od);
		
		return od.getOrderNumber();
	}
	
	// 주문 취소
	public void cancel(long oderid) {
		OrderData od = ors.findOne(oderid);
		od.ordercancer(od);
		ors.delete(od);
	}
	
	// 주문 조회
	public OrderData orderreview(long oderid) {
		return ors.findOne(oderid);
	}
}
