package br.inatel.dm110.log.beans;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.inatel.dm110.api.log.LogTO;
import br.inatel.dm110.interfaces.log.LogLocal;
import br.inatel.dm110.log.entities.Log;

@Stateless
@Local(LogLocal.class)
public class LogBean implements LogLocal {
	
	@PersistenceContext(unitName = "product_pu")
	private EntityManager em;
	
	private static Logger logger = Logger.getLogger(LogBean.class.getName());

	@Override
	public void saveLog(LogTO logTO) {
		Log log = new Log(logTO.getProductCode(), logTO.getOperation());
		logger.info("Salvando o log " + log);
		em.persist(log);
	}

	@Override
	public List<LogTO> listLogsByProductCode(int code) {
		TypedQuery<Log> query = em.createQuery("FROM Log obj WHERE productCode = :code", Log.class);
		query.setParameter("code", code);
		List<Log> logList = query.getResultList();
		return toCollectionAPIModel(logList);
	}

	@Override
	public List<LogTO> listLogs() {
		TypedQuery<Log> query = em.createQuery("FROM Log obj", Log.class);
		
		List<Log> logList = query.getResultList();
		
		return toCollectionAPIModel(logList);
	}
	
	private List<LogTO> toCollectionAPIModel(List<Log> logList) {
		return logList.stream().map(log -> {
			LogTO logTO = new LogTO(log.getId(), log.getProductCode(), log.getOperation(), log.getTimestamp());
			return logTO;
		}).collect(Collectors.toList());
	}

}
