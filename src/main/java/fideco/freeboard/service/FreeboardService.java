package fideco.freeboard.service;

import java.util.ArrayList;
import fideco.freeboard.dto.FreeboardDTO;

public interface FreeboardService {
	

		// Read 작업
	 public ArrayList<FreeboardDTO> freeboardSelectAll();
	 
	 public FreeboardDTO freeboardSelect(int num);
	 
	  // Create 작업
	 public boolean freeboardInsert(FreeboardDTO freeboardDTO);
	  //Update 작업
	 public boolean freeboardUpdate(FreeboardDTO freeboardDTO);
	  //Delete 작업
	 public boolean freeboardDelete(int num);
}