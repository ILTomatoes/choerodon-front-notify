package script.db

databaseChangeLog(logicalFilePath: 'script/db/notify-sitemsg-record.groovy') {
    changeSet(author: 'youquan.deng@hand-china.com', id: '2018-09-10-add-notify-sitemsg-record') {
        if (helper.dbType().isSupportSequence()) {
            createSequence(sequenceName: 'NOTIFY_SITEMSG_RECORD_S', startValue: "1")
        }
        createTable(tableName: "NOTIFY_SITEMSG_RECORD") {
            column(name: 'ID', type: 'BIGINT UNSIGNED', autoIncrement: true, remarks: '表ID，主键，供其他表做外键，unsigned bigint、单表时自增、步长为 1') {
                constraints(primaryKey: true, primaryKeyName: 'PK_NOTIFY_SITEMSG_RECORD')
            }
            column(name: 'USER_ID', type: 'BIGINT UNSIGNED', remarks: '用户id') {
                constraints(nullable: false)
            }
            column(name: 'TITLE', type: 'VARCHAR(64)', remarks: '站内信消息标题')
            column(name: 'CONTENT', type: 'TEXT', remarks: '站内信消息内容')
            column(name: "IS_READ", type: "TINYINT UNSIGNED", defaultValue: "0", remarks: '是否已读。1已读，0未读') {
                constraints(nullable: false)
            }
            column(name: 'IS_DELETED', type: 'TINYINT UNSIGNED', defaultValue: "0", remarks: '是否删除。1标记删除，0未删除') {
                constraints(nullable: false)
            }
            column(name: "SEND_TIME", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")

            column(name: "OBJECT_VERSION_NUMBER", type: "BIGINT UNSIGNED", defaultValue: "1")
            column(name: "CREATED_BY", type: "BIGINT UNSIGNED", defaultValue: "0")
            column(name: "CREATION_DATE", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
            column(name: "LAST_UPDATED_BY", type: "BIGINT UNSIGNED", defaultValue: "0")
            column(name: "LAST_UPDATE_DATE", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
        }
    }
    changeSet(author: 'youquan.deng@hand-china.com', id: '2018-09-12-add-index-userId-deleted-readed') {
        createIndex(tableName: 'NOTIFY_SITEMSG_RECORD', indexName: 'IDX_USERID_DELETED_READ', unique: false) {
            column(name: 'USER_ID')
            column(name: 'IS_DELETED')
            column(name: 'IS_READ')
        }
    }
    changeSet(author: 'youquan.deng@hand-china.com', id: '2018-10-25-add-column') {
        addColumn(tableName: "NOTIFY_SITEMSG_RECORD") {
            column(name: 'TYPE', type: 'VARCHAR(16)', defaultValue: "msg", remarks: '站内信消息类型（消息：msg，通知：notice）', afterColumn: 'CONTENT')
            column(name: 'SEND_BY', type: 'BIGINT UNSIGNED', remarks: '触发此站内信的用户id', afterColumn: 'IS_DELETED')
        }
    }

    changeSet(author: 'superleader8@gmail.com', id: '2018-12-21-add-column') {
        addColumn(tableName: "NOTIFY_SITEMSG_RECORD") {
            column(name: 'SENDER_TYPE', type: 'VARCHAR(32)', defaultValue: "user", remarks: '发送者的类型，包含site/organization/project/user四种类型，默认值是user', afterColumn: 'SEND_BY')
        }
        renameColumn(tableName: 'NOTIFY_SITEMSG_RECORD', oldColumnName: 'SEND_BY', newColumnName: 'SEND_BY', columnDataType: 'BIGINT UNSIGNED', remarks: '触发此站内信的发送者的id')
    }
}