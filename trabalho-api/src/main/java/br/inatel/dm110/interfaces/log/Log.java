package br.inatel.dm110.interfaces.log;

import java.util.List;

import br.inatel.dm110.api.log.LogTO;

public interface Log {

	void saveLog(LogTO log);
	
	List<LogTO> listLogsByProductCode(int code);
	
	List<LogTO> listLogs();
	
}
