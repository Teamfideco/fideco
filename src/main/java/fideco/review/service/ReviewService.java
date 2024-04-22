package fideco.review.service;

import java.util.ArrayList;

import fideco.qna.dto.QnaDTO;
import fideco.review.dto.ReviewDTO;

public interface ReviewService {
	
	public ArrayList<ReviewDTO> reviewSelectAll();
	
	public ReviewDTO reviewSelect(int num);
	
	public boolean reviewInsert(ReviewDTO reviewDTO);
	
	public boolean reviewUpdate(ReviewDTO reviewDTO);
	
	public boolean reviewDelete(int num);

	

	

}
