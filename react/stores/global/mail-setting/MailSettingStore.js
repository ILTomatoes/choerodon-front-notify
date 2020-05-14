import { action, computed, observable } from 'mobx';
import { axios, store } from '@choerodon/boot';

@store('MailSettingStore')
class MailSettingStore {
  @observable mailSettingData = {};

  @action setSettingData(data) {
    this.mailSettingData = data;
  }

  @computed get getSettingData() {
    return this.mailSettingData;
  }

  @action cleanData() {
    this.mailSettingData = {};
  }

  loadData = () => {
    this.cleanData();
    return axios.get('hmsg/choerodon/v1/notices/configs/email');
  }

  updateData = data => axios.put('hmsg/choerodon/v1/notices/configs/email', JSON.stringify(data));

  testConnection = data => axios.post('hmsg/choerodon/v1/notices/configs/email/test', JSON.stringify(data));
}

const mailSettingStore = new MailSettingStore();
export default mailSettingStore;
