package BibleBusiness;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import bibleBeans.BibleObject;

/**
 * Session Bean implementation class BibleBusinessService
 */
@Stateless
@Local(BibleServiceInterface.class)
@LocalBean
@Alternative

public class BibleBusinessService implements BibleServiceInterface{
	BibleObject bible = new BibleObject();

    /**
     * Default constructor. 
     */
    public BibleBusinessService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("Hello from the BibleBusinessService");
		
	}

	@Override
	public BibleObject getBible() {
		// TODO Auto-generated method stub
		return bible;
	}

	@Override
	public void setBible(BibleObject bible) {
		// TODO Auto-generated method stub
		
	}

	



}
