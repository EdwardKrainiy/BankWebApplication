package WebApplication.repository;

import WebApplication.model.BaseEntity;

@SuppressWarnings("JpaQlInspection")
public abstract class EntityRepository<TEntity extends BaseEntity> implements IRepository<TEntity> {

    /*@Override
    public TEntity findById(int id) {
    }

    @Override
    public List<TEntity> findAll(){
    }

    @Override
    public int create(TEntity entity) {
    }

    @Override
    public TEntity update(TEntity entity){
    }

    @Override
    //public void delete(TEntity entity){
    //}

    */public abstract String getTableName();
}


