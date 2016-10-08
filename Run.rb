$: << File.dirname(__FILE__)

require 'gosu'
require 'rubygems'
include Gosu

require 'scripts/PhoneWindow.rb'

$window = PhoneWindow.new
$window.show
