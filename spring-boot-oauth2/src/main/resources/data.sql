INSERT INTO oauth_client_details
    (client_id, client_secret, resource_ids,scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information, autoapprove) VALUES
    ('client_id1', 'secret1', 'resource1','foo,read,write','password,authorization_code,refresh_token', null, null, 36000, 36000, null, true);
