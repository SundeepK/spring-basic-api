require 'json'
require 'rest-client'

When(/^I get ([^"]*)$/) do |path|
  get("http://localhost:8080/#{path}")
end

def get(url)
  begin
    @response = RestClient.get url
  rescue RestClient::ExceptionWithResponse => e
    @response = e.response
  end
end

Then(/^response is a "([^"]*)"$/) do |response_code|
  expect(@response.code.to_s).to eq(response_code)
end

def last_json
  @response
end
