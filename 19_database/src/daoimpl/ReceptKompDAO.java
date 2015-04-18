package daoimpl;

import java.util.List;

import daointerfaces.DALException;
import daointerfaces.IReceptKompDAO;
import dto.ReceptKompDTO;

public class ReceptKompDAO implements IReceptKompDAO {

	@Override
	public ReceptKompDTO getReceptKomp(int receptId, int raavareId)
			throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReceptKompDTO> getReceptKompList(int receptId)
			throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReceptKompDTO> getReceptKompList() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createReceptKomp(ReceptKompDTO receptkomponent)
			throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateReceptKomp(ReceptKompDTO receptkomponent)
			throws DALException {
		// TODO Auto-generated method stub

	}

}
