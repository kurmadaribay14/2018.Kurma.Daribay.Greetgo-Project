package kz.greetgo.blog.stand.bean_containers;

import kz.greetgo.blog.stand.beans.StandServer;
import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.BeanContainer;
import kz.greetgo.depinject.core.Include;

@Include(BeanConfigForStandBeanContainer.class)
public interface StandBeanContainer extends BeanContainer{
  StandServer standServer();

}
