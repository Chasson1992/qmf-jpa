classDiagram
direction BT
class binding {
   varchar(255) arguments
   bigint msg_matched
   varchar(255) exchange_name
   varchar(255) exchange_virtual_host_broker_name
   varchar(255) exchange_virtual_host_name
   varchar(255) queue_name
   varchar(255) queue_virtual_host_broker_name
   varchar(255) queue_virtual_host_name
   varchar(255) origin
   varchar(255) binding_key
}
class broker {
   bigint abandoned
   bigint abandoned_via_alt
   bigint acquires
   bigint byte_depth
   bigint byte_persist_dequeues
   bigint byte_persist_enqueues
   bigint byte_total_dequeues
   bigint byte_total_enqueues
   bigint byte_txn_dequeues
   bigint byte_txn_enqueues
   bigint conn_backlog
   text data_dir
   bigint discards_lvq
   bigint discards_no_route
   bigint discards_overflow
   bigint discards_purge
   bigint discards_ring
   bigint discards_subscriber
   bigint discards_ttl
   bigint max_conns
   bigint mgmt_pub_interval
   bit(1) mgmt_publish
   bigint msg_depth
   bigint msg_persist_dequeues
   bigint msg_persist_enqueues
   bigint msg_total_dequeues
   bigint msg_total_enqueues
   bigint msg_txn_dequeues
   bigint msg_txn_enqueues
   bigint port
   bigint queue_count
   bigint releases
   bigint reroutes
   bigint uptime
   varchar(255) version
   bigint worker_threads
   varchar(255) system_information_id
   varchar(255) name
}
class connection {
   bit(1) incoming
   varchar(255) auth_identity
   bigint bytes_from_client
   bigint bytes_to_client
   bit(1) closing
   bigint frames_from_client
   bigint frames_to_client
   bigint msgs_from_client
   bigint msgs_to_client
   varchar(255) protocol
   bigint remote_parent_pid
   bigint remote_pid
   text remote_process_name
   varchar(255) remote_properties
   varchar(255) sasl_mechanism
   bigint sasl_ssf
   varchar(255) address
   varchar(255) virtual_host_broker_name
   varchar(255) virtual_host_name
}
class exchange {
   varchar(255) arguments
   bit(1) auto_delete
   bigint binding_count
   bigint byte_drops
   bigint byte_receives
   bigint byte_routes
   bit(1) durable
   bigint msg_drops
   bigint msg_receives
   bigint msg_routes
   varchar(255) type
   varchar(255) exchange_name
   varchar(255) exchange_virtual_host_broker_name
   varchar(255) exchange_virtual_host_name
   varchar(255) name
   varchar(255) virtual_host_broker_name
   varchar(255) virtual_host_name
}
class queue {
   bit(1) durable
   bigint acquires
   varchar(255) arguments
   bit(1) auto_delete
   bigint binding_count
   bigint byte_depth
   bigint byte_persist_dequeues
   bigint byte_persist_enqueues
   bigint byte_total_dequeues
   bigint byte_total_enqueues
   bigint byte_txn_dequeues
   bigint byte_txn_enqueues
   bigint consumer_count
   varchar(255) creator
   bigint discards_lvq
   bigint discards_overflow
   bigint discards_purge
   bigint discards_ring
   bigint discards_subscriber
   bigint discards_ttl
   bit(1) exclusive
   bit(1) flow_stopped
   bigint flow_stopped_count
   bigint msg_depth
   bigint msg_persist_dequeues
   bigint msg_persist_enqueues
   bigint msg_total_dequeues
   bigint msg_total_enqueues
   bigint msg_txn_dequeues
   bigint msg_txn_enqueues
   varchar(255) redirect_peer
   bit(1) redirect_source
   bigint releases
   bigint reroutes
   varchar(255) exchange_name
   varchar(255) exchange_virtual_host_broker_name
   varchar(255) exchange_virtual_host_name
   varchar(255) name
   varchar(255) virtual_host_broker_name
   varchar(255) virtual_host_name
}
class session {
   varchar(255) full_name
   bit(1) attached
   bigint channel_id
   bigint expire_time
   bigint txn_commits
   bigint txn_count
   bigint txn_rejects
   bigint txn_starts
   bigint unacked_messages
   varchar(255) connection_address
   varchar(255) connection_virtual_host_broker_name
   varchar(255) connection_virtual_host_name
   varchar(255) name
   varchar(255) virtual_host_broker_name
   varchar(255) virtual_host_name
}
class subscription {
   bit(1) browsing
   varchar(255) queue_name
   varchar(255) queue_virtual_host_broker_name
   varchar(255) queue_virtual_host_name
   varchar(255) session_name
   varchar(255) session_virtual_host_broker_name
   varchar(255) session_virtual_host_name
   bit(1) acknowledged
   varchar(255) arguments
   varchar(255) credit_mode
   bigint delivered
   bit(1) exclusive
   varchar(255) name
}
class system_information {
   varchar(255) machine
   varchar(255) node_name
   varchar(255) os_name
   varchar(255) release
   varchar(255) version
   varchar(255) system_information_id
}
class virtual_host {
   varchar(255) federation_tag
   varchar(255) name
   varchar(255) broker_name
}

binding  -->  exchange : exchange_name, exchange_virtual_host_broker_name, exchange_virtual_host_name:name, virtual_host_broker_name, virtual_host_name
binding  -->  queue : queue_name, queue_virtual_host_broker_name, queue_virtual_host_name:name, virtual_host_broker_name, virtual_host_name
broker  -->  system_information : system_information_id
connection  -->  virtual_host : virtual_host_broker_name, virtual_host_name:broker_name, name
exchange  -->  exchange : exchange_name, exchange_virtual_host_broker_name, exchange_virtual_host_name:name, virtual_host_broker_name, virtual_host_name
exchange  -->  virtual_host : virtual_host_broker_name, virtual_host_name:broker_name, name
queue  -->  exchange : exchange_name, exchange_virtual_host_broker_name, exchange_virtual_host_name:name, virtual_host_broker_name, virtual_host_name
queue  -->  virtual_host : virtual_host_broker_name, virtual_host_name:broker_name, name
session  -->  connection : connection_address, connection_virtual_host_broker_name, connection_virtual_host_name:address, virtual_host_broker_name, virtual_host_name
session  -->  virtual_host : virtual_host_broker_name, virtual_host_name:broker_name, name
subscription  -->  queue : queue_name, queue_virtual_host_broker_name, queue_virtual_host_name:name, virtual_host_broker_name, virtual_host_name
subscription  -->  session : session_name, session_virtual_host_broker_name, session_virtual_host_name:name, virtual_host_broker_name, virtual_host_name
virtual_host  -->  broker : broker_name:name
