import React, { createContext, useMemo, useContext } from 'react';
import { DataSet } from 'choerodon-ui/pro';
import { inject } from 'mobx-react';
import { injectIntl } from 'react-intl';
import MsgRecordStoreObject from './MsgRecordStore';

const Store = createContext();
export function useStore() {
  return useContext(Store);
}
export default Store;

export const StoreProvider = injectIntl(inject('AppState')(
  (props) => {
    const { AppState: { currentMenuType: { type, id, organizationId } }, intl, children } = props;
    const intlPrefix = 'user.userinfo';
    const MsgRecordStore = useMemo(() => new MsgRecordStoreObject(), []);
    const value = {
      ...props,
      prefixCls: 'user-info',
      intlPrefix,
      permissions: [
        'notify-service.message-record-site.pageEmail',
        'notify-service.message-record-org.pageEmail',
      ],
      MsgRecordStore,
    };
    return (
      <Store.Provider value={value}>
        {children}
      </Store.Provider>
    );
  },
));
