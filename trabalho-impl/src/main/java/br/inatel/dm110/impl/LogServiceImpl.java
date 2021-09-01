package br.inatel.dm110.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.api.log.LogService;
import br.inatel.dm110.api.log.LogTO;
import br.inatel.dm110.interfaces.log.LogLocal;

@RequestScoped
public class LogServiceImpl implements LogService {

    @EJB
    private LogLocal logBean;
    
	@Override
	public List<LogTO> listLogsByProductCode(int code) {
		return logBean.listLogsByProductCode(code);
	}

	@Override
	public List<LogTO> listLogs() {
		return logBean.listLogs();
	}


}
