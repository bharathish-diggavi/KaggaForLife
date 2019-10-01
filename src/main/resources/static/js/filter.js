/**
 * 
 */
import $ from './jquery.js';
import Filterizr from './filterizr.js';

	// This will extend the $.fn prototype with Filterizr
	Filterizr.installAsJQueryPlugin($);
		$('.filter-container').filterizr('filter', 5);