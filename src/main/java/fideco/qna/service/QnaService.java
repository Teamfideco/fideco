package fideco.qna.service;

import java.util.ArrayList;

import fideco.qna.dto.QnaDTO;

public interface QnaService {
	
	public ArrayList<QnaDTO> qnaSelectAll();
	
	public QnaDTO qnaSelect(int num);
	
	public boolean qnaInsert(QnaDTO qnaDTO);
	
	public boolean qnaUpdate(QnaDTO qnaDTO);
	
	public boolean qnaDelete(int num);

	

	

}
